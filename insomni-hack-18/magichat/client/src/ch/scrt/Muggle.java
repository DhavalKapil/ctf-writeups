/*
 * Decompiled with CFR 0_124.
 */
package ch.scrt;

import ch.scrt.WizardAPI;
import ch.scrt.model.Artifact;
import ch.scrt.model.Broomstick;
import ch.scrt.model.Cauldron;
import ch.scrt.model.Frog;
import ch.scrt.model.Gem;
import ch.scrt.model.Hat;
import ch.scrt.model.Lamp;
import ch.scrt.model.Mirror;
import ch.scrt.model.Scroll;
import ch.scrt.model.TeaSet;
import ch.scrt.model.Wand;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.InetAddress;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;
import java.util.Scanner;
import javax.rmi.ssl.SslRMIClientSocketFactory;
import org.apache.commons.lang3.tuple.Pair;

public class Muggle {
    public static void main(String[] args) {
        try {
            String choice;
            /*Properties props = System.getProperties();
            props.setProperty("javax.net.ssl.trustStore", "magic_hat_truststore");
            props.setProperty("javax.net.ssl.trustStorePassword", "magic_hat");
            Registry registry = LocateRegistry.getRegistry(InetAddress.getByName("magichat.teaser.insomnihack.ch").getHostName(), 51966, new SslRMIClientSocketFactory());
            */
            Registry registry = LocateRegistry.getRegistry(InetAddress.getByName("localhost").getHostName(), 2020);
            WizardAPI wizardAPI = (WizardAPI)registry.lookup("Wizard");
            Scanner s = new Scanner(System.in);
            for (int idx = 0; idx < 2; ++idx) {
                System.out.println(wizardAPI.message(idx));
                System.out.print("[c]ontinue\n> ");
                choice = "";
                while (!choice.equals("c")) {
                    choice = s.nextLine();
                }
            }
            Hat magicHat = wizardAPI.getMagicHat();
            System.out.println("*you received a Magic Hat!*");
            choice = "";
            while (!choice.equals("q")) {
                System.out.print("[a]dd an artifact inside the Magic Hat\n[s]end the Magic Hat to the Wizard for him to cast a spell\n[i]nspect your hat\n[q]uit \n> ");
                block6 : switch (choice = s.nextLine()) {
                    case "a": {
                        String artifact;
                        System.out.print("[b]roomstick\n[c]auldron\n[g]em\n[f]rog\n[h]at\n[l]amp\n[m]irror\n[s]croll\n[t]ea set\n[w]and\n> ");
                        switch (artifact = s.nextLine()) {
                            case "b": {
                                magicHat.add(new Broomstick());
                                break block6;
                            }
                            case "c": {
                                magicHat.add(new Cauldron());
                                break block6;
                            }
                            case "g": {
                                magicHat.add(new Gem());
                                break block6;
                            }
                            case "f": {
                                magicHat.add(new Frog());
                                break block6;
                            }
                            case "h": {
                                magicHat.add(new Hat());
                                break block6;
                            }
                            case "l": {
                                magicHat.add(new Lamp());
                                break block6;
                            }
                            case "m": {
                                magicHat.add(new Mirror());
                                break block6;
                            }
                            case "s": {
                                magicHat.add(new Scroll());
                                break block6;
                            }
                            case "t": {
                                magicHat.add(new TeaSet());
                                break block6;
                            }
                            case "w": {
                                magicHat.add(new Wand());
                                break block6;
                            }
                        }
                        System.out.println("*unknown artifact, nothing was added*");
                        break;
                    }
                    case "s": {
                        Pair<String, Hat> answer = wizardAPI.castASpell(magicHat);
                        magicHat = answer.getRight();
                        System.out.println(answer.getLeft());
                        break;
                    }
                    case "i": {
                        System.out.println(Muggle.tabularize("1x " + magicHat.toString()));
                        break;
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println("Muggle exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String tabularize(String s) {
        StringBuilder s2 = new StringBuilder();
        int tabLevel = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                ++tabLevel;
                s2.append("\t");
                continue;
            }
            if (c == ']') {
                --tabLevel;
                continue;
            }
            s2.append(c);
            if (c != '\n') continue;
            for (int i = 0; i < tabLevel; ++i) {
                s2.append("\t");
            }
        }
        return s2.toString();
    }
}

