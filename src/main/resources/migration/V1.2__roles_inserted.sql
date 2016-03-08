INSERT INTO `beezzy`.`roles` (`ROLE_NAME`) VALUES ('admin');
INSERT INTO `beezzy`.`roles` (`ROLE_NAME`) VALUES ('owner');
INSERT INTO `beezzy`.`roles` (`ROLE_NAME`) VALUES ('consultant');

INSERT INTO `beezzy`.`permissions` (`PERMISSION_NAME`) VALUES ('ROLE_ADMIN');
INSERT INTO `beezzy`.`permissions` (`PERMISSION_NAME`) VALUES ('ROLE_OWNER');
INSERT INTO `beezzy`.`permissions` (`PERMISSION_NAME`) VALUES ('ROLE_CONSULTANT');

INSERT INTO `beezzy`.`role_to_permission` (`ROLE_ID`, `PERMISSION_ID`) VALUES ('1', '1');
INSERT INTO `beezzy`.`role_to_permission` (`ROLE_ID`, `PERMISSION_ID`) VALUES ('1', '2');
INSERT INTO `beezzy`.`role_to_permission` (`ROLE_ID`, `PERMISSION_ID`) VALUES ('1', '3');
INSERT INTO `beezzy`.`role_to_permission` (`ROLE_ID`, `PERMISSION_ID`) VALUES ('2', '2');
INSERT INTO `beezzy`.`role_to_permission` (`ROLE_ID`, `PERMISSION_ID`) VALUES ('2', '3');
INSERT INTO `beezzy`.`role_to_permission` (`ROLE_ID`, `PERMISSION_ID`) VALUES ('3', '3');
