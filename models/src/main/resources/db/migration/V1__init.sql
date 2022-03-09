-- 회원 시퀀스 생성
create sequence if not exists member_seq;

-- 회원
create table if not exists member
(
    id                         bigint       not null default nextval('member_seq') , -- 회원 고유 번호
    email                      varchar(255) not null unique, -- 이메일
    username                   varchar(255) not null unique, -- 아이디
    password                   varchar(255) not null, -- 비밀번호
    is_account_non_expired     boolean      not null, -- 계정만료여부
    is_account_non_locked      boolean      not null, -- 계정잠김여부
    is_credentials_non_expired boolean      not null, -- 계정인증만료여부
    is_enabled                 boolean      not null, -- 계정활성화여부
    updated_at                 timestamp    not null,     -- 업데이트일시
    created_at                 timestamp    not null,      -- 생성일시
    primary key (id)
);

-- 롤 시퀀스 생성
create sequence if not exists role_seq;

-- 롤 테이블
create table if not exists role (
    id                         bigint       not null default nextval('role_seq'), -- 롤 고유 번호
    role_name                  varchar(255) not null unique ,  -- 롤 이름
    updated_at                 timestamp    not null,     -- 업데이트일시
    created_at                 timestamp    not null      -- 생성일시
);


-- 회원 롤 시퀀스 생성
create sequence if not exists authorization_seq;

-- 멤버롤
create table if not exists authorization
(
    id                         bigint       not null default nextval('authorization_seq'), -- 맵핑 고유 번호
    member_id                  bigint       not null,
    role_id                    bigint       not null,
    updated_at                 timestamp    not null,     -- 업데이트일시
    created_at                 timestamp    not null,      -- 생성일시
    foreign key (member_id) references member(id) on update cascade on delete cascade,
    foreign key (role_id) references role(id) on update cascade on delete cascade
);