create table if not exists ict_operation
(
    id uuid not null default gen_random_uuid (),
    type character varying not null,
    item_code character varying not null,
    identifier character varying not null
);

-- create unique index if not exists unique_config_key on external_config (config_key);
--
-- INSERT INTO external_config (config_key, value)
-- SELECT 'db_initialized', 'sure'
-- WHERE NOT EXISTS (SELECT config_key
--                   FROM external_config
--                   WHERE config_key = 'db_initialized');
