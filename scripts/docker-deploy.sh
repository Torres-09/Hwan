REPOSITORY=/home/ubuntu/app
cd $REPOSITORY

echo "> docker-compose 실행 종료"
docker-compose down

echo "> docker-compose 실행"
docker-compose up -d