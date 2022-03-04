
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
    
    public void pruebaOrdenar() {
        Equipo [] arr = new Equipo[equipos.size()];
        for (int i = 0; i < equipos.size(); i++) {
            arr[i] = equipos.get(i);
        }
        //
        for (int i = 0; i < arr.length - 1; i++) {
            int indice = i;
            for (int j = 0; j < arr.length; j++) {
                int aux = j;
                if (arr[i].getPts() < arr[aux].getPts()) {
                    indice = j;
                }
            }
            Equipo menor = arr[indice];
            arr[indice] = arr[i];
            arr[i] = menor;
        }
        equipos.clear();
        for (int i = 0; i < arr.length; i++) {
            equipos.add(arr[arr.length - (i + 1)]);
        }
    }
    
    public void ordenarPosiciones(Object[] arreglo, int izq, int der) {
        Equipo temp = equipos.get(0);
        int i = izq;
        int j = der;
        Equipo aux = null;
        
        while (i < j) {
            while (((Equipo)arreglo[i]).getPts() <= temp.getPts()) {
                i++;
            }
            while (((Equipo)arreglo[i]).getPts() > temp.getPts()) {
                j--;
            }
            if (i < j) {
                aux = (Equipo)arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = aux;
            }
        }
        
        arreglo[izq] = arreglo[j];
        arreglo[j] = temp;
        if (izq < j - 1) {
            ordenarPosiciones(arreglo, izq, j-1);
        }
        if (j + 1 < der) {
            ordenarPosiciones(arreglo, j + 1, der);
        }
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
