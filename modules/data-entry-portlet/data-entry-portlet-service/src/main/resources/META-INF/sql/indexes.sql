create index IX_1A3F3B82 on NFF_FitnessRecord (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_C204BA84 on NFF_FitnessRecord (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_6C4E2AF1 on NFF_fitness (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_7096B9B3 on NFF_fitness (uuid_[$COLUMN_LENGTH:75$], groupId);