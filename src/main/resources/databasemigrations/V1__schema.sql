DROP TABLE IF EXISTS login_token;
DROP TABLE IF EXISTS videos;

CREATE TABLE login_token (
  id    VARCHAR(255)    PRIMARY KEY NOT NULL,
  user_id VARCHAR(255)              NOT NULL,
  user_name VARCHAR(255)            NOT NULL,
  user_token VARCHAR(4096)           NOT NULL,
  user_session VARCHAR(4096)         NOT NULL,
  auth_pn VARCHAR(255)              NOT NULL,
  auth_pt VARCHAR(255)              NOT NULL,
  hks VARCHAR(255)                  NOT NULL,
  api_version VARCHAR(255)          NOT NULL,
  active BOOLEAN                    DEFAULT TRUE
);

CREATE TABLE videos (
  id    BIGINT SERIAL PRIMARY KEY NOT NULL,
  name VARCHAR(255)              NOT NULL,
  isbn VARCHAR(255)              NOT NULL
);
