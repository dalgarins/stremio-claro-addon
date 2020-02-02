DROP TABLE IF EXISTS LOGIN_TOKEN;
DROP TABLE IF EXISTS VIDEOS;

CREATE TABLE LOGIN_TOKEN (
  id    BIGINT SERIAL PRIMARY KEY NOT NULL,
  user_id VARCHAR(255)              NOT NULL,
  user_name VARCHAR(255)            NOT NULL,
  user_token VARCHAR(255)           NOT NULL,
  user_session VARCHAR(255)         NOT NULL,
  auth_pn VARCHAR(255)              NOT NULL,
  auth_pt VARCHAR(255)              NOT NULL,
  hks VARCHAR(255)                  NOT NULL,
  api_version VARCHAR(255)          NOT NULL,
  name BOOLEAN                      DEFAULT TRUE
);

CREATE TABLE VIDEOS (
  id    BIGINT SERIAL PRIMARY KEY NOT NULL,
  name VARCHAR(255)              NOT NULL,
  isbn VARCHAR(255)              NOT NULL
);
