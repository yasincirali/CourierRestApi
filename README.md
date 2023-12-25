Rest Backend Application with Java SpringBoot

->Application respond 6 different api request which is in the postman collection below
->PostgreSQL database connection is used and tables are below are used in the project

CREATE TABLE IF NOT EXISTS public.attendance_log
(
    id integer NOT NULL DEFAULT nextval('attendance_log_id_seq'::regclass),
    insertdate timestamp without time zone,
    courierid integer,
    storeid integer,
    latitude double precision,
    longtitude double precision,
    CONSTRAINT attendance_log_pkey PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS public.courier
(
    id integer NOT NULL DEFAULT nextval('courier_id_seq'::regclass),
    insertdate date,
    name character varying COLLATE pg_catalog."default",
    surname character varying COLLATE pg_catalog."default",
    CONSTRAINT courier_pkey PRIMARY KEY (id)
)
CREATE TABLE IF NOT EXISTS public.store
(
    id integer NOT NULL DEFAULT nextval('store_id_seq'::regclass),
    insertdate date,
    name character varying COLLATE pg_catalog."default",
    latitude double precision,
    longtitude double precision,
    CONSTRAINT store_pkey PRIMARY KEY (id)
)
[MigrosCourierApplication.postman_collection.json](https://github.com/yasincirali/CourierRestApi/files/13766016/MigrosCourierApplication.postman_collection.json)
[Migros_Online_Case(Java) (1).pdf](https://github.com/yasincirali/CourierRestApi/files/13766017/Migros_Online_Case.Java.1.pdf)
