
package lab7p2_pamelaramirez_12141141;


public class Equipo {
    private String nombre;
    private int jugados, ganados, empatados, perdidos,
            golesFavor, golesContra, dif, pts;

    public Equipo(String nombre, int jugados, int ganados, int empatados, int perdidos, int golesFavor, int golesContra) {
        this.nombre = nombre;
        this.jugados = jugados;
        this.ganados = ganados;
        this.empatados = empatados;
        this.perdidos = perdidos;
        this.golesFavor = golesFavor;
        this.golesContra = golesContra;
        setDif(golesFavor, golesContra);
        setPts(ganados, empatados);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getJugados() {
        return jugados;
    }

    public void setJugados(int jugados) {
        this.jugados = jugados;
    }

    public int getGanados() {
        return ganados;
    }

    public void setGanados(int ganados) {
        this.ganados = ganados;
    }

    public int getEmpatados() {
        return empatados;
    }

    public void setEmpatados(int empatados) {
        this.empatados = empatados;
    }

    public int getPerdidos() {
        return perdidos;
    }

    public void setPerdidos(int perdidos) {
        this.perdidos = perdidos;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    public int getDif() {
        return dif;
    }

    public void setDif(int favor, int contra) {
        this.dif = favor - contra;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int gan, int emp) {
        this.pts = (3 * gan) + emp;
    }
    
    public void simulacionPartido(int golFav, int golCon, boolean empate, boolean gano) {
        jugados++;
        golesFavor += golFav;
        golesContra += golCon;
        if (empate) {
            empatados++;
            pts++;
        }
        else {
            if (gano) {
                ganados++;
                pts += 3;
            }
            else if (!gano) {
                perdidos++;
            }
        }
        setDif(golesFavor, golesContra);
        setPts(ganados, empatados);
    }

    @Override
    public String toString() {
        return nombre + "," + jugados + "," + ganados + "," + empatados + "," + perdidos + "," + golesFavor + "," + golesContra + "," + dif + "," + pts + "\n";
    }
    
}
