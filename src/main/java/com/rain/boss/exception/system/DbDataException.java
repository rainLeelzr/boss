package com.rain.boss.exception.system;

public class DbDataException extends SystemException {

    public DbDataException() {
        super();
    }

    public DbDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public DbDataException(String message) {
        super(message);
    }

    public DbDataException(Throwable cause) {
        super(cause);
    }

    public static DbDataException duplicateRecords(String tableName, String[] queryParams) {
        //模板：数据库表[User]含有多条[userAccount|userPwd]相等的记录
        String template = "数据库表[" + tableName + "]含有多条[";

        String queryParam = "";
        for (int i = 0; i < queryParams.length; i++) {
            String param = queryParams[i];
            queryParam += param;
            if (i == queryParams.length - 2) {
                queryParam += "|";
            }
        }

        template += queryParam + "]相等的记录";

        return new DbDataException(template);
    }
}
