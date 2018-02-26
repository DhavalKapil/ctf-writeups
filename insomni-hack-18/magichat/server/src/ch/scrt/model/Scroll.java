/*
 * Decompiled with CFR 0_124.
 */
package ch.scrt.model;

import ch.scrt.model.Artifact;

public class Scroll
extends Artifact {
    private static final long serialVersionUID = -8302681252939001444L;
    private String content = "     ____________________________\n()==(                           (@==()\n     '___________________________'|\n       |                          |\n       |  *unintelligible runes*  |\n     __)__________________________|\n()==(                            (@==()\n     '---------------------------'";

    @Override
    public String toString() {
        return super.toString() + "\n[" + this.content + "]";
    }
}

