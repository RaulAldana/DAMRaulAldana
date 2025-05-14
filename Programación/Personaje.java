package Personaje;

/**
 *
 * @author Franky Full Power
 */
public class Personaje {
    // Atributos
    private String nombre;
    private String tipo;
    private int vida; // Vida
    private int atqf; // Ataque físico
    private int deffi; // Defensa física
    private int atqe; // Ataque especial
    private int defe; // Defensa especial
    private int cargaOverdrive; // Carga para la habilidad Overdrive
    private boolean enOverdrive; // Indica si Overdrive está activado
    private int calculoatq = 0; // 
    private int calculodef = 0; // 
    private int calculoatqe = 0; //
    private int calculodefe = 0; //
    private int calculoatqen = 0; //
    private int calculodefen = 0; //
    private int calculoatqeen = 0; //
    private int calculodefeen = 0; //
    
    // Constructor
    public Personaje(String nombre, String tipo, int vida,int atqf, int deffi, int atqe, int defe){
        this.nombre = nombre;
        this.tipo = tipo;
        this.vida = vida;
        this.atqf = atqf;
        this.atqf = atqf;
        this.deffi = deffi;
        this.deffi = deffi;
        this.atqe = atqe;
        this.defe = defe;
        this.defe = defe;
        this.cargaOverdrive = 0;
        this.enOverdrive = false;
    }
    
    // Métodos
    
     // Método para realizar un ataque físico
    public void Abocajarro(Personaje enemigo) {
        int ataqueFisico = calculoAtqf();
        int defensaFisicoEn = enemigo.calculoDeffiEn();
        activarOverdrive(); // Comprobar y activar Overdrive si está al 100%
        System.out.println(this.atqf);
        if (enOverdrive == true){
            ataqueFisico = (int) (ataqueFisico * 2);
            System.out.println("OVERDRIVE! " + ataqueFisico);
        }
        int daño = ataqueFisico - defensaFisicoEn;
        if (enemigo.tipo.equals("Acero")){ // Si el tipo es acero hace el doble de daño
            daño *= 2;
            System.out.println("Es supereficaz!");
        }
        if (daño > 0) { // Si el daño es positivo
            enemigo.vida -= daño;
            System.out.println(this.nombre + " hace Abocajarro a " + enemigo.nombre + " causando " + daño + " de daño.");
            System.out.println("El ataque fisico y defensa fisica de " + this.nombre + " han bajado!");
            System.out.println(calculoAtqf());
            
            if (calculoatq > -6) {
                calculoatq--;
            }
            if (calculodef > -6) {
                calculodef--;
            }
            
            } if (enOverdrive == true){
             enOverdrive = false;
             ataqueFisico = this.atqf;
             System.out.println("Overdrive gastado!");
            } else {
            System.out.println(this.nombre + " intenta Abocajarro, pero la defensa de " + enemigo.nombre + " es demasiado alta.");
        }
        aumentarCargaOverdrive(50); // Aumenta la carga después de un ataque
        System.out.println(calculoAtqf());
        System.out.println("");
    }

    // Método para realizar un ataque especial
    public void Lanzallamas(Personaje enemigo) {
        int ataqueEspecial = calculoAtqe();
        int defensaEspecialEn = calculoDefeEn();
        activarOverdrive(); // Comprobar y activar Overdrive si está al 100%
        System.out.println(this.atqe);
        if (enOverdrive == true){
            ataqueEspecial = (int) (ataqueEspecial * 2);
            System.out.println("OVERDRIVE! " + this.atqe);
        }
        int daño = ataqueEspecial - defensaEspecialEn;
        if (enemigo.tipo.equals("Acero")){ // Si el tipo es acero hace el doble de daño
            daño *= 2;
            System.out.println("Es supereficaz!");
        }
        if (daño > 0) { // Si el daño es positivo
            enemigo.vida -= daño;
            System.out.println(this.nombre + " hace Lanzallamas a " + enemigo.nombre + " causando " + daño + " de daño.");
            } if (enOverdrive == true){
             enOverdrive = false;
             ataqueEspecial = this.atqe;
             System.out.println("Overdrive gastado!");
             System.out.println(this.atqe);
        } else {
            System.out.println(this.nombre + " intenta Lanzallamas, pero la defensa de " + enemigo.nombre + " es demasiado alta.");
        }
        aumentarCargaOverdrive(50); // Aumenta la carga después de un ataque
        System.out.println("");
    }
    
    // Método para aumentar el ataque del usuario a +2
    public void DanzaEspada(){
        if (calculoatq < 6){
            calculoatq += 2;
            System.out.println("El ataque de " + this.nombre + " a aumentado muchísimo!");
            System.out.println("Ataque a +" + calculoatq );
        } else {
            System.out.println("El ataque de " + this.nombre + " no puede aumentar más!");
            System.out.println();
        }
    }
    
    // Método para bajar las stats defensivas especial del enemigo a -2
    public void OjosLlorosos(Personaje enemigo){
        if (calculodefeen > -6){
            calculodefeen -= 2;
            System.out.println("La defensa especial de " + enemigo.nombre + " ha bajado muchísimo!");
            System.out.println(calculodefeen);
            System.out.println(calculoDefeEn());
        } else {
            System.out.println("La defensa especial de " + enemigo.nombre + " no puede disminuir más!");
            }
    }
    
     // Método para activar Overdrive si la carga llega al 100%
    private void activarOverdrive() {
        if (cargaOverdrive >= 100) {
            enOverdrive = true;
            cargaOverdrive = 0; // Reiniciar la carga después de activar
            System.out.println(this.nombre + " ha activado Overdrive! Su ataque aumenta un 100%.");
        }
    }

    // Método para aumentar la carga de Overdrive
    private void aumentarCargaOverdrive(int cantidad) {
        if (!enOverdrive) {
            cargaOverdrive = Math.min(100, cargaOverdrive + cantidad);
            System.out.println(this.nombre + " aumenta su carga de Overdrive a " + cargaOverdrive + "%.");
        }
    }
    
    public int calculoAtqf(){
        double multiplicadorAtq = 0;
        switch (calculoatq) {
            case -1:
                multiplicadorAtq = 0.75;
                break;
            case -2:
                multiplicadorAtq = 0.6;
                break;
            case -3:
                multiplicadorAtq = 0.5;
                break;
            case -4:
                multiplicadorAtq = 0.43;
                break;
            case -5:
                multiplicadorAtq = 0.38;
                break;
            case -6:
                multiplicadorAtq = 0.33;
                break;
            default:
                multiplicadorAtq = 1;
            case 1:
                multiplicadorAtq = 1.33;
                break;
            case 2:
                multiplicadorAtq = 1.67;
                break;
            case 3:
                multiplicadorAtq = 2;
                break;
            case 4:
                multiplicadorAtq = 2.33;
                break;
            case 5:
                multiplicadorAtq = 2.67;
                break;
            case 6:
                multiplicadorAtq = 3;
                break;
        }
        return (int)(this.atqf * multiplicadorAtq);
    }
    
    public int calculoDeffi(){
        double multiplicadorDef = 0;
        switch (calculodef) {
            case -1:
                multiplicadorDef = 0.75;
                break;
            case -2:
                multiplicadorDef = 0.6;
                break;
            case -3:
                multiplicadorDef = 0.5;
                break;
            case -4:
                multiplicadorDef = 0.43;
                break;
            case -5:
                multiplicadorDef = 0.38;
                break;
            case -6:
                multiplicadorDef = 0.33;
                break;
            default:
                multiplicadorDef = 1;
            case 1:
                multiplicadorDef = 1.33;
                break;
            case 2:
                multiplicadorDef = 1.67;
                break;
            case 3:
                multiplicadorDef = 2;
                break;
            case 4:
                multiplicadorDef = 2.33;
                break;
            case 5:
                multiplicadorDef = 2.67;
                break;
            case 6:
                multiplicadorDef = 3;
                break;
        }
        return (int)(this.deffi * multiplicadorDef);
    }
    
    public int calculoAtqe(){
        double multiplicadorAtqe = 0;
        switch (calculoatqe) {
            case -1:
                multiplicadorAtqe = 0.75;
                break;
            case -2:
                multiplicadorAtqe = 0.6;
                break;
            case -3:
                multiplicadorAtqe = 0.5;
                break;
            case -4:
                multiplicadorAtqe = 0.43;
                break;
            case -5:
                multiplicadorAtqe = 0.38;
                break;
            case -6:
                multiplicadorAtqe = 0.33;
                break;
            default:
                multiplicadorAtqe = 1;
                break;
            case 1:
                multiplicadorAtqe = 1.33;
                break;
            case 2:
                multiplicadorAtqe = 1.67;
                break;
            case 3:
                multiplicadorAtqe = 2;
                break;
            case 4:
                multiplicadorAtqe = 2.33;
                break;
            case 5:
                multiplicadorAtqe = 2.67;
                break;
            case 6:
                multiplicadorAtqe = 3;
                break;
        }
        return (int) (this.atqe * multiplicadorAtqe);
    }
    
    public int calculoDefe(){
         double multiplicadorDefe = 0;
         switch (calculodefe) {
            case -1:
                multiplicadorDefe = 0.75;
                break;
            case -2:
                multiplicadorDefe = 0.6;
                break;
            case -3:
                multiplicadorDefe = 0.5;
                break;
            case -4:
                multiplicadorDefe = 0.43;
                break;
            case -5:
                multiplicadorDefe = 0.38;
                break;
            case -6:
                multiplicadorDefe = 0.33;
                break;
            default:
                multiplicadorDefe = 1;
                break;
            case 1:
                multiplicadorDefe = 1.33;
                break;
            case 2:
                multiplicadorDefe = 1.67;
                break;
            case 3:
                multiplicadorDefe = 2;
                break;
            case 4:
                multiplicadorDefe = 2.33;
                break;
            case 5:
                multiplicadorDefe = 2.67;
                break;
            case 6:
                multiplicadorDefe = 3;
                break;
        }
         return (int) (this.defe * multiplicadorDefe);
    }
    
    public int calculoAtqfEn(){
        double multiplicadorAtq = 0;
        switch (calculoatqen) {
            case -1:
                multiplicadorAtq = 0.75;
                break;
            case -2:
                multiplicadorAtq = 0.6;
                break;
            case -3:
                multiplicadorAtq = 0.5;
                break;
            case -4:
                multiplicadorAtq = 0.43;
                break;
            case -5:
                multiplicadorAtq = 0.38;
                break;
            case -6:
                multiplicadorAtq = 0.33;
                break;
            default:
                multiplicadorAtq = 1;
            case 1:
                multiplicadorAtq = 1.33;
                break;
            case 2:
                multiplicadorAtq = 1.67;
                break;
            case 3:
                multiplicadorAtq = 2;
                break;
            case 4:
                multiplicadorAtq = 2.33;
                break;
            case 5:
                multiplicadorAtq = 2.67;
                break;
            case 6:
                multiplicadorAtq = 3;
                break;
        }
        return (int)(this.atqf * multiplicadorAtq);
    }
    
    public int calculoDeffiEn(){
        double multiplicadorDef = 0;
        switch (calculodefen) {
            case -1:
                multiplicadorDef = 0.75;
                break;
            case -2:
                multiplicadorDef = 0.6;
                break;
            case -3:
                multiplicadorDef = 0.5;
                break;
            case -4:
                multiplicadorDef = 0.43;
                break;
            case -5:
                multiplicadorDef = 0.38;
                break;
            case -6:
                multiplicadorDef = 0.33;
                break;
            default:
                multiplicadorDef = 1;
            case 1:
                multiplicadorDef = 1.33;
                break;
            case 2:
                multiplicadorDef = 1.67;
                break;
            case 3:
                multiplicadorDef = 2;
                break;
            case 4:
                multiplicadorDef = 2.33;
                break;
            case 5:
                multiplicadorDef = 2.67;
                break;
            case 6:
                multiplicadorDef = 3;
                break;
        }
        return (int)(this.deffi * multiplicadorDef);
    }
    
    public int calculoAtqeEn(){
        double multiplicadorAtqe = 0;
        switch (calculoatqeen) {
            case -1:
                multiplicadorAtqe = 0.75;
                break;
            case -2:
                multiplicadorAtqe = 0.6;
                break;
            case -3:
                multiplicadorAtqe = 0.5;
                break;
            case -4:
                multiplicadorAtqe = 0.43;
                break;
            case -5:
                multiplicadorAtqe = 0.38;
                break;
            case -6:
                multiplicadorAtqe = 0.33;
                break;
            default:
                multiplicadorAtqe = 1;
                break;
            case 1:
                multiplicadorAtqe = 1.33;
                break;
            case 2:
                multiplicadorAtqe = 1.67;
                break;
            case 3:
                multiplicadorAtqe = 2;
                break;
            case 4:
                multiplicadorAtqe = 2.33;
                break;
            case 5:
                multiplicadorAtqe = 2.67;
                break;
            case 6:
                multiplicadorAtqe = 3;
                break;
        }
        return (int) (this.atqe * multiplicadorAtqe);
    }
    
    public int calculoDefeEn(){
         double multiplicadorDefe = 0;
         switch (calculodefeen) {
            case -1:
                multiplicadorDefe = 0.75;
                break;
            case -2:
                multiplicadorDefe = 0.6;
                break;
            case -3:
                multiplicadorDefe = 0.5;
                break;
            case -4:
                multiplicadorDefe = 0.43;
                break;
            case -5:
                multiplicadorDefe = 0.38;
                break;
            case -6:
                multiplicadorDefe = 0.33;
                break;
            default:
                multiplicadorDefe = 1;
                break;
            case 1:
                multiplicadorDefe = 1.33;
                break;
            case 2:
                multiplicadorDefe = 1.67;
                break;
            case 3:
                multiplicadorDefe = 2;
                break;
            case 4:
                multiplicadorDefe = 2.33;
                break;
            case 5:
                multiplicadorDefe = 2.67;
                break;
            case 6:
                multiplicadorDefe = 3;
                break;
        }
         return (int) (this.defe * multiplicadorDefe);
    }
    
    // Método para mostrar el estado actual del personaje
    public void mostrarEstado() {
        System.out.println("Nombre: " + nombre + ", Vida: " + vida + ", Overdrive: " + cargaOverdrive + "%.");
    }
}
