/*
 * Decompiled with CFR 0_124.
 */
package ch.scrt.model;

import java.io.Serializable;

public abstract class Artifact
implements Serializable {
    private static final long serialVersionUID = 5612698299188628963L;
    private Essence essence = Essence.ORDINARY;

    Artifact() {
    }

    public String toString() {
        return this.essence.name().toLowerCase() + " " + this.getClass().getSimpleName().toLowerCase();
    }

    public boolean equals(Object o) {
        return this.toString().equals(o.toString());
    }

    public int hashCode() {
        return this.toString().hashCode();
    }

    private static enum Essence {
        ORDINARY,
        MAGIC;
        

        private Essence() {
        }
    }

}

