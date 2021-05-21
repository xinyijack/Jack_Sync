package com.xinyijack.jack_sync.mybatisdemo.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface DatabaseMapper {
    @Select("SELECT * FROM db_info;")
    @Results({
            @Result(property = "dbId", column = "db_id"),
            @Result(property = "dbHost", column = "db_host"),
            @Result(property = "dbPort", column = "db_port"),
            @Result(property = "dbUsername", column = "db_username"),
            @Result(property = "dbPassword", column = "db_password"),
            @Result(property = "dbDatabase", column = "db_name"),
            @Result(property = "dbOutputfile", column = "db_outputfile"),
            @Result(property = "dbFilename", column = "db_filename")
    })
    List<DatabaseInfo> getAllDBInfo();

    /* 通过id查询备份信息 */
    @Select("SELECT * FROM db_info WHERE db_id = #{dbId};")
    @Results({
            @Result(property = "dbId", column = "db_id"),
            @Result(property = "dbHost", column = "db_host"),
            @Result(property = "dbPort", column = "db_port"),
            @Result(property = "dbUsername", column = "db_username"),
            @Result(property = "dbPassword", column = "db_password"),
            @Result(property = "dbDatabase", column = "db_name"),
            @Result(property = "dbOutputfile", column = "db_outputfile"),
            @Result(property = "dbFilename", column = "db_filename")
    })
    DatabaseInfo getDBInfo(String dbId);

    /* 插入操作 */
    @Insert("INSERT INTO db_info (db_id, db_host, db_port, db_username, db_password, db_name, db_outputfile, db_filename) VALUES(#{dbId}, #{dbHost}, #{dbPort}, #{dbUsername}, #{dbPassword}, #{dbDatabase}, #{dbOutputfile}, #{dbFilename});")
    @Options(useGeneratedKeys=true, keyProperty="dbId", keyColumn="db_id")
    int insertDB(DatabaseInfo databaseInfo);

    /* 修改操作 */
    @Update("UPDATE db_info SET db_host=#{dbHost},db_port=#{dbPort},db_username=#{dbUsername},db_password=#{dbPassword},db_name=#{dbDatabase},db_outputfile=#{dbOutputfile},db_filename=#{dbFilename} WHERE db_id =#{dbId};")
    int updateDB(DatabaseInfo databaseInfo);

    /* 删除操作 */
    @Delete("DELETE FROM db_info WHERE db_id =#{dbId};")
    int deleteDB(String dbId);
}
