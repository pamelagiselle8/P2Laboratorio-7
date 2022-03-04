
package lab7p2_pamelaramirez_12141141;

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;


public class Administracion {
    private ArrayList <Equipo> equipos = new ArrayList();
    private File archivo = null;

    public Administracion(File file) {
        archivo = file;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Equipo x : equipos) {
                bw.newLine();
                bw.write(x.getNombre() + ",");
                bw.write(x.getJugados() + ",");
                bw.write(x.getGanados() + ",");
                bw.write(x.getEmpatados() + ",");
                bw.write(x.getPerdidos() + ",");
                bw.write(x.getGolesFavor() + ",");
                bw.write(x.getGolesContra() + ",");
                bw.write(x.getDif() + ",");
                bw.write(x.getPts());
            }
            bw.flush();
        } catch (Exception ex) {
            
        }
        bw.close();
        fw.close();
    }

    public void cargarArchivo() {
        Scanner sc = null;
        equipos = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter(",");
                while (sc.hasNextLine()) {
                    equipos.add(new Equipo(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
                    sc.nextLine();
                }
            }
            catch (Exception e) {
                
            }
            sc.close();
        }
    }

    @Override
    public String toString() {
        return "Administracion{" + "equipos=" + equipos + ", archivo=" + archivo + '}';
    }
    
}
