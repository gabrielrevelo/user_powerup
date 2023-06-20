-- Roles
INSERT INTO `user_powerup`.`role` (`id`, `description`, `name`)
VALUES ('1', ROLE_ADMIN, 'ROLE_ADMIN'),
       ('2', 'ROLE_OWNER', 'ROLE_OWNER'),
       ('3', 'ROLE_EMPLOYEE', 'ROLE_EMPLOYEE'),
       ('4', 'ROLE_CLIENT', 'ROLE_CLIENT');

-- Usuarios
INSERT INTO `user_powerup`.`user` (`id`, `date_of_birth`, `dni_number`, `mail`, `name`, `password`, `phone`, `surname`,
                                   `id_role`)
VALUES ('1', '2000 - 01 - 01 ', '1111111111 ', 'admin1@example.com', 'Admin1',
        '$2a$10$TfOmAuog.hA8T35xq/hHPeWMxnQlSQBIVGBP/bUMKX.IR0IFYOlYe', ' + 573001111111 ', 'Example1', '1 '),
       ('2', '2000 - 01 - 01 ', '2222222222 ', 'owner2@example.com', 'Owner2',
        '$2a$10$.eDh9kmXfhsOmL2LTSHasu1Z0yQktth1GQX19.kCU.7punJ.1cotu', ' + 573002222222 ', 'Example2', '2 '),
       ('3', '2000 - 01 - 01 ', '3333333333 ', 'owner3@example.com', 'Owner3',
        '$2a$10$DljvjrJ7JvsxidS7XmbsguV2ZCJBd3AR7pfKzqA8PUiJyaMIQRO4C', ' + 573003333333 ', 'Example3', '2 '),
       ('4', '2000 - 01 - 01 ', '4444444444 ', 'employee4@example.com', 'Employee4',
        '$2a$10$Gp3frS6Hny42LmfXt3nzW.So3XvOJXTYIU6CKAKli876aj.bYFSB6', ' + 573004444444 ', 'Example4', '3 '),
       ('5', '2000 - 01 - 01 ', '5555555555 ', 'employee5@example.com', 'Employee5',
        '$2a$10$y0B0nEz9MwBkTp0p/oCTm.WNDCoCkQQugeLHGMAt5MU/iEWY4gHdm', ' + 573005555555 ', 'Example5', '3 '),
       ('6', '2000 - 01 - 01 ', '6666666666 ', 'client6@example.com', 'Client6',
        '$2a$10$mUNL.zvq3F3HpdyRoZKHY.cDzLfZhAiAh/kxfAV2AJ/uGX9n2CJKy', ' + 573006666666 ', 'Example6', '4 '),
       ('7', '2000 - 01 - 01 ', '7777777777 ', 'gabriel@example.com', 'Gabriel',
        '$2a$10$pvptofHS0P0qF9osHJaFZOfBPV8R6mH56dpJ3rA/mXerFTDK.TJtK', ' + 573113013781 ', 'Revelo', '4 ');