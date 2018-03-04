package de.danielflow.project.SkyPermissions.Exception;

public class OnlyPlayerException extends Exception {

    private static final long serialVersionUID = -1180843285391670029L;

    public OnlyPlayerException() {
	super("Halt Stopp, nur Spieler d�rfen das!");
    }

}
