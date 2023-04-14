package com.example.amanid;

public class HelperClass {
    String idnum;
    String pass;
    String pass2;
    String qhint;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }



    public String getQhint() {
        return qhint;
    }

    public void setQhint(String qhint) {
        this.qhint = qhint;
    }



    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }


    public String getIdnum() {
        return idnum;
    }

    public void setIdnum(String idnum) {
        this.idnum = idnum;
    }

    public HelperClass(String idnum , String pass , String pass2, String qhint) {
        this.idnum = idnum;
        this.pass2 = pass2;
        this.pass =pass;
        this.qhint = qhint;
    }


    public HelperClass() {
    }
}
