package fr.guic.model;

public enum PersonStatus {
    Alive (1),
    Dead (0);

    private Integer code;

    PersonStatus(Integer code){
        this.code = code;
    }

    public String toString(){
        return code.toString();
    }
}