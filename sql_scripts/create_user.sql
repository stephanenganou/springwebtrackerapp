CREATE USER 'appstest'@'localhost' IDENTIFIED BY 'appstest';

GRANT ALL PRIVILEGES ON * . * TO 'appstest'@'localhost';

ALTER USER 'appstest'@'localhost' IDENTIFIED WITH mysql_native_password
	BY 'training';