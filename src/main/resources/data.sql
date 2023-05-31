INSERT INTO `role` (`id`, `description`, `name`)
VALUES ('1', 'ROLE_ADMIN', 'ROLE_ADMIN');
INSERT INTO `role` (`id`, `description`, `name`)
VALUES ('2', 'ROLE_OWNER', 'ROLE_OWNER');

INSERT INTO `user_powerup`.`user` (`id`, `date_of_birth`, `dni_number`, `mail`, `name`, `password`, `phone`, `surname`,
                                   `id_role`)
VALUES ('1', '2000-01-01', '1111111111', 'admin1@example.com', 'Admin1',
        '$2a$10$C3SMlUzEU6MuDG4e2qHvpOBo.Y2tG4w4Y6MnU4KJIp0D7XTfi/hTi', '+573001111111', 'Example', '1');
INSERT INTO `user_powerup`.`user` (`id`, `date_of_birth`, `dni_number`, `mail`, `name`, `password`, `phone`, `surname`,
                                   `id_role`)
VALUES ('2', '2000-01-01', '2222222222', 'owner2@example.com', 'Owner2',
        '$2a$10$C3SMlUzEU6MuDG4e2qHvpOBo.Y2tG4w4Y6MnU4KJIp0D7XTfi/hTi', '+573002222222', 'Example', '2');
INSERT INTO `user_powerup`.`user` (`id`, `date_of_birth`, `dni_number`, `mail`, `name`, `password`, `phone`, `surname`,
                                   `id_role`)
VALUES ('3', '2000-01-01', '3333333333', 'owner3@example.com', 'Owner3',
        '$2a$10$C3SMlUzEU6MuDG4e2qHvpOBo.Y2tG4w4Y6MnU4KJIp0D7XTfi/hTi', '+573003333333', 'Example', '2');