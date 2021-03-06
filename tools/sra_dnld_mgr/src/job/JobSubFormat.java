/* ===========================================================================
#
#                            PUBLIC DOMAIN NOTICE
#               National Center for Biotechnology Information
#
#  This software/database is a "United States Government Work" under the
#  terms of the United States Copyright Act.  It was written as part of
#  the author's official duties as a United States Government employee and
#  thus cannot be copyrighted.  This software/database is freely available
#  to the public for use. The National Library of Medicine and the U.S.
#  Government have not placed any restriction on its use or reproduction.
#
#  Although all reasonable efforts have been taken to ensure the accuracy
#  and reliability of the software and data, the NLM and the U.S.
#  Government do not and cannot warrant the performance or results that
#  may be obtained by using this software or data. The NLM and the U.S.
#  Government disclaim all warranties, express or implied, including
#  warranties of performance, merchantability or fitness for any particular
#  purpose.
#
#  Please cite the author in any work or product based on this material.
#
=========================================================================== */
package job;

public enum JobSubFormat
{
    INVALID             ( 0,    "INVALID" ),
    SPOT                ( 1,    "WHOLE READ" ),
    FRAGMENTS           ( 2,    "READ FRAGMENTS" ),
    FRAGMENTS_SPLITED   ( 3,    "READ FRAGMENTS SPLIT" );

    private final int value;
    private final String txt;
    private static final JobSubFormat[] allValues = values();
    
    public static JobSubFormat from_ordinal( int i )
    {
        if ( i < 0 || i > 3 ) i = 0;
        return allValues[ i ];
    }
    
    public static JobSubFormat from_string( String s )
    {
        if ( s.equals( SPOT.txt ) )
            return SPOT;
        else if ( s.equals( FRAGMENTS.txt ) )
            return FRAGMENTS;
        else if ( s.equals( FRAGMENTS_SPLITED.txt ) )
            return FRAGMENTS_SPLITED;
        return INVALID;
    }    

    public int to_ordinal() { return value; }
    public String to_string() { return txt; }
    
    public static String[] to_StringList()
    {
        String[] res = new String[ allValues.length ];
        int i = 0;
        for ( JobSubFormat jf : allValues ) res[ i++ ] = jf.txt;
        return res;
    }

    public static String[] to_StringList( JobSubFormat excluded )
    {
        String[] res = new String[ allValues.length - 1 ];
        int i = 0;
        for ( JobSubFormat jf : allValues )
        {
            if ( !jf.equals( excluded ) )
                res[ i++ ] = jf.txt;
        }
        return res;
    }
    
    private JobSubFormat( int value, String txt )
    {
        this.value = value;
        this.txt = txt;
    }
}
