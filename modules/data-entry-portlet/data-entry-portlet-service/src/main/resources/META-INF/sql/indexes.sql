create index IX_8F95235C on NFF_FitnessRecord (groupId);
create index IX_6FFB0518 on NFF_FitnessRecord (studentId[$COLUMN_LENGTH:75$]);
create index IX_B5840B48 on NFF_FitnessRecord (userId);
create index IX_1A3F3B82 on NFF_FitnessRecord (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_C204BA84 on NFF_FitnessRecord (uuid_[$COLUMN_LENGTH:75$], groupId);