package com.xinyijack.jack_sync.mybatisdemo.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BackupMapper {
    @Select("SELECT * FROM backup_info;")
    @Results({
            @Result(property = "bpId", column = "bp_id"),
            @Result(property = "tdbName", column = "tdb_name"),
            @Result(property = "tdbTablename", column = "tdb_tablename"),
            @Result(property = "tdbBackupdate", column = "tdb_backupdate"),
            @Result(property = "tdbBackuptype", column = "tdb_backuptype"),
            @Result(property = "tdbBackupstatus", column = "tdb_backupstatus")
    })
    List<BackupInfo> getAllBackupInfo();

    /* 通过id查询备份信息 */
    @Select("SELECT * FROM backup_info WHERE bp_id = #{bpId};")
    @Results({
            @Result(property = "bpId", column = "bp_id"),
            @Result(property = "tdbName", column = "tdb_name"),
            @Result(property = "tdbTablename", column = "tdb_tablename"),
            @Result(property = "tdbBackupdate", column = "tdb_backupdate"),
            @Result(property = "tdbBackuptype", column = "tdb_backuptype"),
            @Result(property = "tdbBackupstatus", column = "tdb_backupstatus")
    })
    BackupInfo getBackupInfo(String bpId);

    /* 插入操作 */
    @Insert("INSERT INTO backup_info (bp_id, tdb_name, tdb_tablename, tdb_backupdate, tdb_backuptype, tdb_backupstatus) VALUES(#{bpId}, #{tdbName}, #{tdbTablename}, #{tdbBackupdate}, #{tdbBackuptype}, #{tdbBackupstatus});")
    @Options(useGeneratedKeys=true, keyProperty="bpId", keyColumn="bp_id")
    int insertBackupInfo(BackupInfo backupInfo);

    /* 修改操作 */
    @Update("UPDATE backup_info SET tdb_name=#{tdbName},tdb_tablename=#{tdbTablename},tdb_backuptype=#{tdbBackuptype},tdb_backupstatus=#{tdbBackupstatus} WHERE bp_id=#{bpId};")
    int updateBackupInfo(BackupInfo backupInfo);

    /* 删除操作 */
    @Delete("DELETE FROM backup_info WHERE bp_id =#{bpId};")
    int deleteBackupInfo(String bpId);
}
