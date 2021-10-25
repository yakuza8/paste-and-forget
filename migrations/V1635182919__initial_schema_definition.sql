CREATE TABLE `paste` (
    `shortlink` VARCHAR(64) NOT NULL,
    `content_path` VARCHAR(64) NOT NULL,
    `expiration_in_minutes` INT(10),
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `expires_at` TIMESTAMP NOT NULL,
    PRIMARY KEY (`shortlink`),
    INDEX `expires_at_idx` (`expires_at`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;