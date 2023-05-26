/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import DataStructures.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Juan
 */
public class  Util {
    

    
    public String ObtenerRutaTXT() {
        String fileRoute; 
        JFileChooser fi = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        
        int option = fi.showOpenDialog(null);
        
        if (option == 0)
        {
            
            fileRoute = fi.getSelectedFile().getAbsolutePath();
            if (!fileRoute.endsWith("txt")) {
                JOptionPane.showMessageDialog(null, "formato de archivo no valido, intente de nuevo");
            }
            
        } else
        {
            fileRoute = "";
        }
        return fileRoute;
    }
    
    public void WriteTxt(List allPerson,String fileRoute) {
        if ("".equals(fileRoute))
        {
            JOptionPane.showMessageDialog(null, "Error! No hay ruta de acceso.");
        } else
        {
            String str = "Usuarios\n";
            if (allPerson.isEmpty() == false)
            {
                for (int x = 0; x < allPerson.len(); x++)
                {
                    Vperson person = (Vperson) allPerson.get(x);
                    str = str + person.getVnum() + "," + person.getName() + "\n";
                }
                str = str + "Relaciones\n";
                for (int x = 0; x < allPerson.len(); x++)
                {
                    Vperson person = (Vperson) allPerson.get(x);
                    List auxList = person.getAdyList();
                    for (int y = 0; y < auxList.len(); y++)
                    {
                        Edge edge = (Edge) auxList.get(y);
                        str = str + Integer.toString(edge.getStart()) + "," + Integer.toString(edge.getEnd()) + "," + Integer.toString(edge.getWeight()) + "\n";
                    }
                }
            }
            try{
               PrintWriter pw = new PrintWriter(fileRoute); 
               pw.print(str);
               pw.close();
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Error! No se ha escrito sobre el archivo.");
            }
        }
    }
    
    public List read_users(String fileRoute){
        List persons = new List();
        
        String line;
        String str = "";
        
        File newFile = new File(fileRoute);
        try {
            if (newFile.exists() == false) {
                newFile.createNewFile();
            } else {
                FileReader fr = new FileReader(newFile);
                BufferedReader br = new BufferedReader(fr);

                while (!"Relaciones".equals(line = br.readLine())) {
                    if (line.isEmpty() == false && line.equals("Usuarios") == false) {
                        str += line + "\n";
                    }
                }
                if ("".equals(str) == false) {
                    String[] str_split = str.split("\n");
                    for (int x = 0; x < str_split.length; x++) {
                        String[] Str = str_split[x].split(",");
                        Vperson person = new Vperson(Integer.parseInt(Str[0]), Str[1]);
                        persons.append(person);
                    }
                }
                br.close();

            }
        } catch (Exception e) {
            
        }
        return persons;
        
        
    }
    
    public List read_relations(List allPerson, String fileRoute) {
        List relations = new List();
        String line;
        String str = "";
        
        File newFile = new File(fileRoute);
        try {
            if (newFile.exists() == false) {
                newFile.createNewFile();
            } else {
                FileReader fr = new FileReader(newFile);
                BufferedReader br = new BufferedReader(fr);

                boolean run = false;
                while (null != (line = br.readLine())) {
                    if (line.isEmpty() == false && line.equals("Usuarios") == false && run == true) {
                        str += line + "\n";
                    }
                    if (line.equals("Relaciones") == true) {
                        run = true;
                    }

                }

                if ("".equals(str) == false) {
                    String[] str_split = str.split("\n");
                    for (int x = 0; x < str_split.length; x++) {
                        String[] Str = str_split[x].split(",");
                        Edge newEdge = new Edge(Integer.parseInt(Str[0]), Integer.parseInt(Str[1]), Integer.parseInt(Str[2]));
                        relations.append(newEdge);
                    }
                }
                br.close();

            }
        } 
        catch (Exception e) {
            
        }
        return relations;
    }
    
    public static boolean isNumeric(String str) {
    if (str == null || str.isEmpty()) {
        return false;
    }

    try {
        Double.parseDouble(str);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}
    
}