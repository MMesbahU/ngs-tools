cmake_minimum_required (VERSION 2.8.12)

set ( CMAKE_OSX_DEPLOYMENT_TARGET 10.6 )

# best to use at the top
project ( ngs-tools )

# this has to follow the project() command!
set(CMAKE_MODULE_PATH
    ${CMAKE_MODULE_PATH}
    "${CMAKE_CURRENT_SOURCE_DIR}/build/cmake"
)
include ( env )

add_subdirectory(ngs-vdb)
add_subdirectory(tools)

set ( CPACK_PACKAGE_NAME ngs-tools )
set ( CPACK_PACKAGE_VERSION 0.1 )
set ( CPACK_PACKAGE_CONTACT "sra-tools@ncbi.nlm.nih.gov" )
set ( CPACK_PACKAGE_DESCRIPTION_SUMMARY "some tools that use NGS" )

set ( CPACK_DEBIAN_PACKAGE_ARCHITECTURE amd64 )

include ( CPack )
