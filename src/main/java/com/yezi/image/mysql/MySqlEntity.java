package com.yezi.image.mysql;

public class MySqlEntity {
    ConnectionImple connectionImple;
    PersonExecutorImple personExecutorImple;
    public static MySqlEntity mySqlEntity;

    private MySqlEntity(){
        connectionImple = ConnectionImple.getConnectionImple();
        personExecutorImple = new PersonExecutorImple(connectionImple.getConnection(),"Person");
    }

    public PersonExecutorImple getPersonExecutorImple() {
        return personExecutorImple;
    }

    public static MySqlEntity getMySqlEntity() {
        if(mySqlEntity == null)
            mySqlEntity = new MySqlEntity();
        return mySqlEntity;
    }
}
