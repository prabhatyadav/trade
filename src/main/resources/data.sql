-- CREATE TABLE trade 
--  ( 
  --   id        BIGINT(20) UNSIGNED NOT NULL, 
    -- type      VARCHAR(30), 
    -- symbol    VARCHAR(30), 
    -- shares    INT(10), 
    -- price     INT(10), 
    -- timestamp TIMESTAMP, 
    -- PRIMARY KEY (id) 
--  ); 

-- CREATE TABLE user 
--  ( 
 --    id   BIGINT(20) UNSIGNED NOT NULL, 
--     name VARCHAR(100), 
--     PRIMARY KEY (id) 
 -- ); 
  
INSERT INTO trade ( id, type, symbol,shares,price,timestamp) VALUES ( 1, 'fuck', '$',20,100, '2008-01-01 00:00:01');

INSERT INTO user ( id, name) VALUES (1, 'fuck_king');