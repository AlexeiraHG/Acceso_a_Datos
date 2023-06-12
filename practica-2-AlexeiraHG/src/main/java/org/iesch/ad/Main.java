package org.iesch.ad;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import com.thoughtworks.xstream.XStream;
import org.iesch.ad.Model.UZ_data;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static ArrayList<UZ_data> UZDatalst;
    private static StringBuilder txtConsultas = new StringBuilder("");

    public static void main(String[] args) throws IOException {

        //convertirCSVaXML();

        cargarCSVaMemoria();

       // consultas();

        JsonAsignaturasTeruel();


    }

    private static void JsonAsignaturasTeruel() {
        try {
            ObjectMapper mapper = new ObjectMapper();

            ObjectNode AsiganturasIngieneriaInformatica = mapper.createObjectNode();
            List<UZ_data> list = UZDatalst.stream().filter(item -> item.getLOCALIDAD().equals("Teruel")).collect(Collectors.toList());
            System.out.println(list);
            list.forEach(uz_data -> AsiganturasIngieneriaInformatica.put("Asignatura", uz_data.getASIGNATURA()));

            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(AsiganturasIngieneriaInformatica);
            try {
                String ruta = "out/IngInformaticaTeruel.json";

                File file = new File(ruta);
                // Si el archivo no existe es creado
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.flush();
                bw.write(String.valueOf(json));
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void txtConsultasCrear(StringBuilder txt) {

        try {
            String ruta = "out/UZ_dataEJ1_consultas.txt";

            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.flush();
            bw.write(String.valueOf(txt));
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void consultas() {
        AsignaturaConMasSuspensos();
        AsignaturasDeTeruel();
        AsignaturaTeruelConMasSuspenso();
        AsignaturaTerualMasPresentado();
        AsignaturaMasSuspensosInformatica();
        OptativaMasSuspensos();
        AsignaturaMAsFacilDerecho();

        txtConsultasCrear(txtConsultas);
    }

    private static void AsignaturaMAsFacilDerecho() {

        System.out.println("Asignatura Facultad de Derecho más fácil: ");
        List<UZ_data> list = UZDatalst.stream()
                .filter(item -> item.getCENTRO().equals("Facultad de Derecho"))
                .filter(item -> item.getTASA_EXITO() != null)
                .max(Comparator.comparingDouble(UZ_data::getTASA_EXITO))
                .stream().collect(Collectors.toList());

        list.forEach(UZ_data -> System.out.println(UZ_data.getASIGNATURA() + ", Tasa de éxito: " + UZ_data.getTASA_EXITO()));

        txtConsultas.append("Asignatura Facultad de Derecho más fácil: ");
        txtConsultas.append(list.get(0).getASIGNATURA() + ", Tasa de éxito: " + list.get(0).getTASA_EXITO() + "\n");

    }

    private static void OptativaMasSuspensos() {
        System.out.println("Asignatura optativa con mayor número de suspensos");
        List<UZ_data> list = UZDatalst.stream()
                .filter(item -> item.getCLASE_ASIGNATURA().equals("Optativa"))
                .filter(item -> item.getTASA_EXITO() != null)
                .min(Comparator.comparingDouble(UZ_data::getTASA_EXITO))
                .stream().collect(Collectors.toList());

        list.forEach(UZ_data -> System.out.println(UZ_data.getESTUDIO() + ", " + UZ_data.getASIGNATURA() + ", Tasa de éxito: " + UZ_data.getTASA_EXITO()));

        txtConsultas.append("Asignatura optativa con mayor número de suspensos: ");
        txtConsultas.append(list.get(0).getESTUDIO() + ", " + list.get(0).getASIGNATURA() + ", Tasa de éxito: " + list.get(0).getTASA_EXITO() + "\n");

    }

    private static void AsignaturaMasSuspensosInformatica() {
        System.out.println("Asignatura con menor tasa de éxito que se estudia en la carrera de Grado: Ingeniería Informática:");
        List<UZ_data> list = UZDatalst.stream()
                .filter(item -> item.getLOCALIDAD().equals("Teruel"))
                .filter(item -> item.getESTUDIO().equals("Grado: Ingeniería Informática"))
                .filter(item -> item.getTASA_EXITO() != null)
                .min(Comparator.comparingDouble(UZ_data::getTASA_EXITO))
                .stream().collect(Collectors.toList());

        list.forEach(UZ_data -> System.out.println(UZ_data.getASIGNATURA() + ", Tasa de éxito: " + UZ_data.getTASA_EXITO()));

        txtConsultas.append("Asignatura con menor tasa de éxito que se estudia en la carrera de Grado: Ingeniería Informática: ");
        txtConsultas.append(list.get(0).getASIGNATURA() + ", Tasa de éxito: " + list.get(0).getTASA_EXITO() + "\n");

    }

    private static void AsignaturaTerualMasPresentado() {
        System.out.println("Asignatura de Teruel con mayor número de presentados:");
        List<UZ_data> list = UZDatalst.stream()
                .filter(item -> item.getLOCALIDAD().equals("Teruel"))
                .max(Comparator.comparingDouble(UZ_data::getALUMNOS_PRESENTADOS))
                .stream().collect(Collectors.toList());

        list.forEach(UZ_data -> System.out.println(UZ_data.getASIGNATURA()));

        txtConsultas.append("Asignatura de Teruel con mayor número de presentados: ");
        txtConsultas.append(list.get(0).getASIGNATURA() + "\n");

    }

    private static void AsignaturaTeruelConMasSuspenso() {

        System.out.println("Asignaturas en Teruel con mayor número de suspensos");

        List<UZ_data> list = UZDatalst.stream()
                .filter(item -> item.getLOCALIDAD().equals("Teruel"))
                .filter(item -> item.getTASA_EXITO() != null).collect(Collectors.toList());

        list.stream().sorted(Comparator.comparingDouble(UZ_data::getTASA_EXITO))
                .limit(3)
                .forEach(uz_data -> System.out.println(uz_data.getASIGNATURA() + ", Tasa de éxito: " + uz_data.getTASA_EXITO()));


        txtConsultas.append("Asignaturas en Teruel con mayor número de suspensos: " + "\n");
        list.stream().sorted(Comparator.comparingDouble(UZ_data::getTASA_EXITO))
                .limit(3)
                .forEach(uz_data -> txtConsultas.append(uz_data.getASIGNATURA() + ", Tasa de éxito: " + uz_data.getTASA_EXITO() + "\n"));
        txtConsultas.append("\n");

    }

    private static void AsignaturasDeTeruel() {

        List<UZ_data> list = UZDatalst.stream().filter(item -> item.getLOCALIDAD().equals("Teruel"))
                .collect(Collectors.toList());


        System.out.println("Asiganturas que se pueden estudiar en Teruel (" + list.size() + "): ");
        list.forEach(uz_data -> System.out.println(uz_data.getASIGNATURA()));
        System.out.println("\n");


        txtConsultas.append("Asiganturas que se pueden estudiar en Teruel (" + list.size() + "): " + "\n");
        list.forEach(uz_data -> txtConsultas.append(uz_data.getASIGNATURA() + "\n"));
        txtConsultas.append("\n");
    }

    private static void AsignaturaConMasSuspensos() {
        System.out.println("Asiganturas con mas suspensos: ");
        List<UZ_data> list = UZDatalst.stream().filter(item -> item.getTASA_EXITO() != null).collect(Collectors.toList());

        list.stream().sorted(Comparator.comparingDouble(UZ_data::getTASA_EXITO))
                .limit(3)
                .forEach(uz_data -> System.out.println(uz_data.getASIGNATURA() + ", Tasa de éxito: " + uz_data.getTASA_EXITO()));

        txtConsultas.append("Asiganturas con mas suspensos: " + "\n");
        list.stream().sorted(Comparator.comparingDouble(UZ_data::getTASA_EXITO))
                .limit(3)
                .forEach(uz_data -> txtConsultas.append(uz_data.getASIGNATURA() + ", Tasa de éxito: " + uz_data.getTASA_EXITO() + "\n"));
        txtConsultas.append("\n");

    }

    private static void cargarCSVaMemoria() {
        UZDatalst = new ArrayList<>();
        try {
            CSVReader reader = new CSVReaderBuilder(new FileReader("data/UZ_data.csv")).build();
            String[] header = reader.readNext();
            String[] nextLine;

            while ((nextLine = reader.readNext()) != null) {

                UZ_data uzd = new UZ_data();
                uzd.setTIPO_ESTUDIO(nextLine[1]);
                uzd.setESTUDIO(nextLine[2]);
                uzd.setLOCALIDAD(nextLine[3]);
                uzd.setCENTRO(nextLine[4]);
                uzd.setASIGNATURA(nextLine[5]);
                uzd.setCLASE_ASIGNATURA(nextLine[7]);
                if (nextLine[13].isEmpty() || nextLine[8].isEmpty() || Integer.parseInt(nextLine[13]) == 0) {
                    uzd.setALUMNOS_PRESENTADOS(0);
                    uzd.setTASA_EXITO(null);
                } else {
                    uzd.setALUMNOS_PRESENTADOS(Integer.parseInt(nextLine[13]));
                    uzd.setTASA_EXITO(Double.parseDouble(nextLine[8]));
                }

                UZDatalst.add(uzd);
            }
            System.out.println(UZDatalst.size() + " datos cargados a memoria");

        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e.getCause() + e.getMessage());
        }

    }

    private static void convertirCSVaXML() {
        String startFile = "data/UZ_data.csv";
        String outFile = "out/UZ_dataEJ1.xml";

        try {
            CSVReader reader = new CSVReader(new FileReader(startFile));

            String[] line = null;

            String[] header = reader.readNext();

            List out = new ArrayList();

            while ((line = reader.readNext()) != null) {
                List<String[]> item = new ArrayList<String[]>();
                for (int i = 0; i < header.length; i++) {
                    String[] keyVal = new String[2];
                    String string = header[i];
                    String val = line[i];
                    keyVal[0] = string;
                    keyVal[1] = val;
                    item.add(keyVal);
                }
                out.add(item);
            }

            XStream xstream = new XStream();

            xstream.toXML(out, new FileWriter(outFile, false));

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("CSV parseado a XML");
    }
}
