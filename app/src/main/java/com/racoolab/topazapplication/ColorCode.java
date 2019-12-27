package com.racoolab.topazapplication;

public class ColorCode {

    private Boolean checked;
    private String colorcode;
    private String colorcodein;

    public Boolean getChecked() {
        return checked;
    }



    public void setChecked(Boolean checked) { this.checked = checked;
    }

    public String getColorcode() {
        return colorcode;
    }

    public void setColorcode(String colorcode) {

        colorcodein = colorcode.replace("#","");

        if(colorcodein != null && colorcodein.length() == 6){
            if((colorcodein.matches(".*[0-9].*"))||((colorcodein.matches(".*[A-Z].*")))){
                this.colorcode = colorcode;
            } else {
                this.colorcode = "#000000";
            }
        } else {
            this.colorcode = "#000000";
        }

    }




}
