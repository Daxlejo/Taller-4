interface GeneradorExamen {
    void generarExamen();
}

interface SistemaEvaluacion {
    void evaluar();
}

interface SistemaSupervision {
    void supervisar();
}

class GeneradorExamenEnLinea implements GeneradorExamen {
    public void generarExamen() {
        System.out.println("Generando examen en línea con preguntas aleatorias.");
    }
}

class SistemaEvaluacionEnLinea implements SistemaEvaluacion {
    public void evaluar() {
        System.out.println("Evaluando automáticamente el examen en línea.");
    }
}

class SistemaSupervisionEnLinea implements SistemaSupervision {
    public void supervisar() {
        System.out.println("Supervisando examen en línea mediante cámara e IA.");
    }
}

class GeneradorExamenPresencial implements GeneradorExamen {
    public void generarExamen() {
        System.out.println("Generando examen presencial impreso.");
    }
}

class SistemaEvaluacionPresencial implements SistemaEvaluacion {
    public void evaluar() {
        System.out.println("Docente evaluando examen presencial manualmente.");
    }
}

class SistemaSupervisionPresencial implements SistemaSupervision {
    public void supervisar() {
        System.out.println("Supervisor controlando examen presencial en aula.");
    }
}

class GeneradorExamenMixto implements GeneradorExamen {
    public void generarExamen() {
        System.out.println("Generando examen mixto (digital y físico).");
    }
}

class SistemaEvaluacionMixto implements SistemaEvaluacion {
    public void evaluar() {
        System.out.println("Evaluando examen mixto con sistema automático y revisión manual.");
    }
}

class SistemaSupervisionMixto implements SistemaSupervision {
    public void supervisar() {
        System.out.println("Supervisando examen mixto con IA y supervisor presencial.");
    }
}

interface FabricaExamen {
    GeneradorExamen crearGeneradorExamen();
    SistemaEvaluacion crearSistemaEvaluacion();
    SistemaSupervision crearSistemaSupervision();
}

class FabricaExamenEnLinea implements FabricaExamen {
    public GeneradorExamen crearGeneradorExamen() {
        return new GeneradorExamenEnLinea();
    }
    public SistemaEvaluacion crearSistemaEvaluacion() {
        return new SistemaEvaluacionEnLinea();
    }
    public SistemaSupervision crearSistemaSupervision() {
        return new SistemaSupervisionEnLinea();
    }
}

class FabricaExamenPresencial implements FabricaExamen {
    public GeneradorExamen crearGeneradorExamen() {
        return new GeneradorExamenPresencial();
    }
    public SistemaEvaluacion crearSistemaEvaluacion() {
        return new SistemaEvaluacionPresencial();
    }
    public SistemaSupervision crearSistemaSupervision() {
        return new SistemaSupervisionPresencial();
    }
}

class FabricaExamenMixto implements FabricaExamen {
    public GeneradorExamen crearGeneradorExamen() {
        return new GeneradorExamenMixto();
    }
    public SistemaEvaluacion crearSistemaEvaluacion() {
        return new SistemaEvaluacionMixto();
    }
    public SistemaSupervision crearSistemaSupervision() {
        return new SistemaSupervisionMixto();
    }
}

public class Principal {

    public static void main(String[] args) {

        System.out.println("=== EJEMPLO: Examen en linea");
        FabricaExamen fabricaOnline = new FabricaExamenEnLinea();
        ejecutarExamen(fabricaOnline);

        System.out.println("\n=== EJEMPLO: Examen presencial ===");
        FabricaExamen fabricaPresencial = new FabricaExamenPresencial();
        ejecutarExamen(fabricaPresencial);

        System.out.println("\n=== EJEMPLO: Examen mixto ===");
        FabricaExamen fabricaMixto = new FabricaExamenMixto();
        ejecutarExamen(fabricaMixto);
    }

    private static void ejecutarExamen(FabricaExamen fabrica) {
        GeneradorExamen generador = fabrica.crearGeneradorExamen();
        SistemaEvaluacion evaluacion = fabrica.crearSistemaEvaluacion();
        SistemaSupervision supervision = fabrica.crearSistemaSupervision();

        generador.generarExamen();
        supervision.supervisar();
        evaluacion.evaluar();
    }
}