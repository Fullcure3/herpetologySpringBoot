package org.portfolio.security;

public enum ApplicationUserPermission {
    GENUS_READ("genus:read"),
    GENUS_WRITE("genus:write"),
    GENUS_DELETE("genus:delete"),
    CLASSIFICATION_READ("classification:read");

    private String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
