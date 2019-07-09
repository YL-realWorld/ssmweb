package com.luma.Common.pojos.vo;

/**
 * urNameIsMyLife
 * 2019/7/9
 */
public class UserLogin {

    public enum PathType {

        LOGIN("login"), LOGOUT("logout");

        private String value;

        PathType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum Role {

        ADMIN("admin"), USER("user");

        private String value;

        Role(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    private String pathType;

    private String role;

    private String userName;

    public String getPathType() {
        return pathType;
    }

    public void setPathType(String pathType) {
        this.pathType = pathType;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "pathType='" + pathType + '\'' +
                ", role='" + role + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
