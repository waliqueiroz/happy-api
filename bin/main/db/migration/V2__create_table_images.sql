CREATE TABLE IF NOT EXISTS images
(
    id bigint(20) PRIMARY KEY NOT NULL,
    path varchar(255) NOT NULL,
    orphanage_id bigint(20) NOT NULL,
    created_at datetime,
    updated_at datetime,
    FOREIGN KEY(orphanage_id) REFERENCES orphanages(id)
);