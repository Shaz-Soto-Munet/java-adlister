USE adlister_db;

CREATE TABLE users (
    id INT AUTO_INCREMENT NOT NULL,
    username VARCHAR(30) NOT NULL,
    email VARCHAR(30) NOT NULL,
    password VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ads (
    id INT AUTO_INCREMENT NOT NULL,
    user_id INT NOT NULL,
    title VARCHAR(200) NOT NULL,
    description TEXT,
    PRIMARY KEY (id),
    CONSTRAINT ads_users_id_fk FOREIGN KEY (user_id) REFERENCES users (id)
);

DESCRIBE users;

DESCRIBE ads;

INSERT INTO users (username, email, password) VALUES
              ('Shaz', 'shaz@codeup.com', 'codeup-1'),
              ('User2', 'user2@codeup.com', 'codeup-1');

INSERT INTO ads (user_id, title, description) VALUES
            ('1', 'Guitar For Sale', 'Pre-owned electric guitar in great condition ready to be bought.'),
            ('2', 'Truck For Sale', '2008 Toyota Tacoma 200000 miles slightly used only accepting 50000 cash');

INSERT INTO ads (user_id, title, description) VALUES
                                                  ('1', 'Synth For Sale', 'Pre-owned synth in great condition ready to be bought.');
