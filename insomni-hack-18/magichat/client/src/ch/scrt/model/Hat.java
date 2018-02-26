/*
 * Decompiled with CFR 0_124.
 */
package ch.scrt.model;

import org.apache.commons.collections.Bag;
import org.apache.commons.collections.bag.HashBag;

import ch.scrt.model.Artifact;

public class Hat
extends Artifact {
    private static final long serialVersionUID = 2028004707566014564L;
    private Bag content = new HashBag();

    public void add(Artifact a) {
        this.content.add(a);
    }

    @Override
    public String toString() {
        String str = super.toString();
        if (!this.content.isEmpty()) {
            str = str + " that contains: \n" + this.content.toString().replace(":", "x ").replace(',', '\n');
        }
        return str;
    }
}

