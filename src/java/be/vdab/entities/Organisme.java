/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.entities;

/**
 *
 * @author Admin
 */
public abstract class Organisme {

    private int levenskracht;
    private boolean handelingGedaan;

    public Organisme(int levenskracht) {
        this.levenskracht = levenskracht;
    }

    public int getLevenskracht() {
        return levenskracht;
    }

    public void setLevenskracht(int levenskracht) {
        this.levenskracht = levenskracht;
    }

    public boolean isHandelingGedaan() {
        return handelingGedaan;
    }

    public void setHandelingGedaan(boolean handelingGedaan) {
        this.handelingGedaan = handelingGedaan;
    }

    public boolean getHandelingGedaan() {
        return handelingGedaan;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.levenskracht;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Organisme other = (Organisme) obj;
        if (this.levenskracht != other.levenskracht) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return Integer.toString(levenskracht);
    }

}
