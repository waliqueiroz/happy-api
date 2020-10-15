CREATE TABLE IF NOT EXISTS orphanages
(
    id bigint(20) PRIMARY KEY NOT NULL,
    name varchar(255) NOT NULL,
    latitude decimal(2,10) NOT NULL,
    longitude decimal(2,10) NOT NULL,
    about text NOT NULL,
    instructions text NOT NULL,
    opening_hours varchar(255) NOT NULL,
    open_on_weekends tinyint NOT NULL DEFAULT 0,
    created_at datetime,
    updated_at datetime
);