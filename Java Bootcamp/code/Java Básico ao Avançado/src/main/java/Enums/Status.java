package Enums;

public enum Status {
    OPEN(13, "Aberto"),
    CLOSE(02, "Fechado");

    private int cod;
    private String text;

    Status(int cod, String text) {
        this.cod = cod;
        this.text = text;
    }

    public int getCod() {
        return cod;
    }

    public String getText() {
        return text;
    }
}
