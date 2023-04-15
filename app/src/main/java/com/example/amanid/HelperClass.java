package com.example.amanid;

public class HelperClass {
    String indium;
    String pass;
    String pass2;
    String hint;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }



    public String gethint() {
        return hint;
    }

    public void sethint(String hint) {
        this.hint = hint;
    }



    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }


    public String getindium() {
        return indium;
    }

    public void setindium(String indium) {
        this.indium = indium;
    }

    public HelperClass(String idnum , String pass , String pass2, String qhint) {
        this.indium = idnum;
        this.pass2 = pass2;
        this.pass =pass;
        this.hint = qhint;
    }


    public HelperClass() {
    }
}
