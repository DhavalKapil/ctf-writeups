/*
 * Decompiled with CFR 0_124.
 */
package ch.scrt;

import ch.scrt.model.Hat;
import java.rmi.Remote;
import java.rmi.RemoteException;
import org.apache.commons.lang3.tuple.Pair;

public interface WizardAPI
extends Remote {
    public static final int PORT = 51966;
    public static final String IP = "magichat.teaser.insomnihack.ch";

    public String message(int var1) throws RemoteException;

    public Hat getMagicHat() throws RemoteException;

    public Pair<String, Hat> castASpell(Hat var1) throws RemoteException;
}

