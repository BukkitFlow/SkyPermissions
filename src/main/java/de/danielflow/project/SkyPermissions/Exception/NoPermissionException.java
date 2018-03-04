package de.danielflow.project.SkyPermissions.Exception;

public class NoPermissionException extends Exception {
    private static final long serialVersionUID = 1L;

    public NoPermissionException() {
	super("Du hast keine Rechte daf�r!");
    }
}
