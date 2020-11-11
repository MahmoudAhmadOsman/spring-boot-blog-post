CREATE TABLE `posts` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(250) NOT NULL,
	`author` VARCHAR(250) NOT NULL,
	`post_image` VARCHAR(250) NOT NULL,
	`post_content` VARCHAR(250) NOT NULL,
	`created_at` DATETIME NOT NULL,
	`updated_at` DATETIME NOT NULL,
	PRIMARY KEY (`id`)
);