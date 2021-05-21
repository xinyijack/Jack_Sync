package com.xinyijack.jack_sync.mybatisdemo.mapper;

import org.apache.ibatis.annotations.*;
import java.util.List;

public interface RecoverMapper {
    @Select("SELECT * FROM recover_info;")
    @Results({
            @Result(property = "rcId", column = "rc_id"),
            @Result(property = "tdbName", column = "tdb_name"),
            @Result(property = "tdbTablename", column = "tdb_tablename"),
            @Result(property = "tdbRecoverdate", column = "tdb_recoverdate"),
            @Result(property = "tdbRecovertype", column = "tdb_recovertype"),
            @Result(property = "tdbRecoverstatus", column = "tdb_recoverstatus")
    })
    List<RecoverInfo> getAllRecoverInfo();

    /* 通过id查询备份信息 */
    @Select("SELECT * FROM recover_info WHERE rc_id = #{rcId};")
    @Results({
            @Result(property = "rcId", column = "rc_id"),
            @Result(property = "tdbName", column = "tdb_name"),
            @Result(property = "tdbTablename", column = "tdb_tablename"),
            @Result(property = "tdbRecoverdate", column = "tdb_recoverdate"),
            @Result(property = "tdbRecovertype", column = "tdb_recovertype"),
            @Result(property = "tdbRecoverstatus", column = "tdb_recoverstatus")
    })
    RecoverInfo getRecoverInfo(String rcId);

    /* 插入操作 */
    @Insert("INSERT INTO recover_info (rc_id, tdb_name, tdb_tablename, tdb_recoverdate, tdb_recovertype, tdb_recoverstatus) VALUES(#{rcId}, #{tdbName}, #{tdbTablename}, #{tdbRecoverdate}, #{tdbRecovertype}, #{tdbRecoverstatus});")
    @Options(useGeneratedKeys=true, keyProperty="rcId", keyColumn="rc_id")
    int insertRecoverInfo(RecoverInfo recoverInfo);

    /* 修改操作 */
    @Update("UPDATE recover_info SET tdb_name=#{tdbName},tdb_tablename=#{tdbTablename},tdb_recovertype=#{tdbRecovertype},tdb_recoverstatus=#{tdbRecoverstatus} WHERE rc_id =#{rcId};")
    int updateRecoverInfo(RecoverInfo recoverInfo);

    /* 删除操作 */
    @Delete("DELETE FROM recover_info WHERE rc_id =#{rcId};")
    int deleteRecoverInfo(String rcId);
}
