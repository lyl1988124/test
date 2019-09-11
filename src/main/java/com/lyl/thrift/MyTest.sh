#thrift --gen java -out ./ MyTest.thrift
#thrift --gen py -out ./ MyTest.thrift
thrift -r --gen py MyTest.thrift
cp com/lyl/thrift/* ./
rm -rf com