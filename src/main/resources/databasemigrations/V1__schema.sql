DROP TABLE IF EXISTS login_token;
DROP TABLE IF EXISTS videos;

CREATE TABLE login_token (
  user_id VARCHAR(255)              PRIMARY KEY NOT NULL,
  user_name VARCHAR(255)            NOT NULL,
  user_token VARCHAR(4096)          NOT NULL,
  user_session VARCHAR(4096)        NOT NULL,
  auth_pn VARCHAR(255)              NOT NULL,
  auth_pt VARCHAR(255)              NOT NULL,
  hks VARCHAR(255)                  NOT NULL,
  api_version VARCHAR(255)          NOT NULL
);

CREATE TABLE videos (
  video_id VARCHAR(255)              PRIMARY KEY NOT NULL,
  title VARCHAR(255)                 NOT NULL,
  title_original VARCHAR(255)        NOT NULL,
  description VARCHAR(4096)          NOT NULL,
  image_medium VARCHAR(4096)         NOT NULL,
  image_large VARCHAR(255)           NOT NULL,
  duration VARCHAR(255)              NOT NULL,
  year_ VARCHAR(255)                 NOT NULL
);
