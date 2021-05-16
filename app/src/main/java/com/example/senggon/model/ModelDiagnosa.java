package com.example.senggon.model;

public class ModelDiagnosa extends ModelSymtoms{
    public static String MODELDIAGNOSA="ModelDiagnosa";
    private boolean checked;
    public ModelDiagnosa(String id, String description,boolean checked) {
        super(id, description);
        this.checked=checked;
    }
    public ModelDiagnosa(ModelSymtoms symtoms, boolean checked){
        this.id=symtoms.getId();
        this.description=symtoms.getDescription();
        this.checked=checked;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
