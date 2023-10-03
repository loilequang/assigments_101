 -- shop.coffee_shop definition

-- Drop table

-- DROP TABLE shop.coffee_shop;

CREATE TABLE shop.coffee_shop (
	shop_id int8 NOT NULL,
	"name" bpchar(50) NULL,
	contact_name bpchar(100) NULL,
	CONSTRAINT shop_pkey PRIMARY KEY (shop_id)
);
-- shop."order" definition

-- Drop table

-- DROP TABLE shop."order";

CREATE TABLE shop."order" (
	order_id int8 NOT NULL,
	order_code bpchar(20) NULL,
	shop_id int8 NULL,
	queue_id int8 NULL,
	order_at timestamptz NULL,
	address bpchar(200) NULL,
	status bpchar(12) NULL,
	customer_name bpchar(100) NULL,
	CONSTRAINT order_pkey PRIMARY KEY (order_id)
);
-- shop.order_detail definition

-- Drop table

-- DROP TABLE shop.order_detail;

CREATE TABLE shop.order_detail (
	id int8 NOT NULL,
	order_id int8 NULL,
	m_id int8 NULL,
	quantity int4 NULL,
	amount int8 NULL,
	CONSTRAINT order_detail_pkey PRIMARY KEY (id)
);
-- shop.shop_config definition

-- Drop table

-- DROP TABLE shop.shop_config;

CREATE TABLE shop.shop_config (
	config_id int8 NOT NULL,
	shop_id int8 NULL,
	"location" bpchar(100) NULL,
	open_time timestamptz NULL,
	close_time timestamptz NULL,
	queue_number int4 NULL,
	queue_number_max_item int4 NULL,
	CONSTRAINT shop_config_pkey PRIMARY KEY (config_id)
);
-- shop.shop_menu definition

-- Drop table

-- DROP TABLE shop.shop_menu;

CREATE TABLE shop.shop_menu (
	m_id int8 NOT NULL,
	shop_id int8 NULL,
	title bpchar(100) NULL,
	is_active bool NULL,
	price int4 NULL,
	CONSTRAINT shop_menu_pkey PRIMARY KEY (m_id)
);
-- shop.shop_queue_number definition

-- Drop table

-- DROP TABLE shop.shop_queue_number;

CREATE TABLE shop.shop_queue_number (
	id int8 NOT NULL,
	shop_id int8 NULL,
	queue_id int8 NULL,
	order_number int4 NULL,
	CONSTRAINT shop_queue_number_pkey PRIMARY KEY (id)
);
-- shop."user" definition

-- Drop table

-- DROP TABLE shop."user";

CREATE TABLE shop."user" (
	user_name bpchar(100) NOT NULL,
	full_name bpchar(100) NULL,
	email bpchar(100) NULL,
	"password" text NULL,
	roles bpchar(500) NULL,
	status bpchar(10) NULL,
	address varchar(255) NULL,
	order_code varchar(255) NULL,
	order_at timestamp(6) NULL,
	queue_id int4 NULL,
	shop_id int4 NULL,
	CONSTRAINT student_email_unique UNIQUE (email),
	CONSTRAINT user_pkey PRIMARY KEY (user_name)
);