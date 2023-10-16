CREATE TABLE stores (
    id SERIAL PRIMARY KEY,
    name VARCHAR(155) NOT NULL,
    address VARCHAR(255) NOT NULL,
    number INT NOT NULL,
    complement VARCHAR(100),
    neighbor VARCHAR(100),
    state VARCHAR(4),
    city VARCHAR(60),
    country VARCHAR(4),
    status VARCHAR(30) NOT NULL,
    user_id INT NOT NULL
);

CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(80) NOT NULL,
    brand VARCHAR(80) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    description VARCHAR NOT NULL,
    category VARCHAR(50),
    stock INT NOT NULL,
    store_id INT NOT NULL,

    FOREIGN KEY (store_id) REFERENCES stores(id)
);

CREATE TABLE sales (
    id SERIAL PRIMARY KEY,
    costumer_id INT NOT NULL,
    total_price DOUBLE PRECISION,
    tax INT NOT NULL,
    sale_date DATE,
    store_id INT NOT NULL,

    FOREIGN KEY (store_id) REFERENCES stores(id)
);

CREATE TABLE sales_products (
    id SERIAL PRIMARY KEY,
    sale_id INT,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    product_price DOUBLE PRECISION NOT NULL,

    FOREIGN KEY (sale_id) REFERENCES sales(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);
