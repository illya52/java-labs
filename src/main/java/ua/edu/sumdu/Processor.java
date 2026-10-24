package ua.edu.sumdu;

package ua.edu.sumdu;

public class Processor {
    private String model;
    private int cores;

    public Processor(String model, int cores) {
        setModel(model);
        setCores(cores);
    }

    public String getModel() { return model; }

    public void setModel(String model) {
        if (model == null || model.trim().isEmpty()) {
            throw new IllegalArgumentException("Модель процесора не може бути порожньою.");
        }
        this.model = model;
    }

    public int getCores() { return cores; }

    public void setCores(int cores) {
        if (cores <= 0) {
            throw new IllegalArgumentException("Кількість ядер має бути більше 0.");
        }
        this.cores = cores;
    }

    @Override
    public String toString() {
        return model + " (" + cores + " ядер)";
    }
}